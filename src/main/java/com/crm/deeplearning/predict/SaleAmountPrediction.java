package com.crm.deeplearning.predict;

/**
 * Created by JackKo
 * 2018/8/17 10:39
 **/

import com.crm.deeplearning.representation.SaleAmountDataSetIterator;
import com.crm.deeplearning.utils.PlotUtil;
import javafx.util.Pair;
import org.deeplearning4j.nn.modelimport.keras.exceptions.InvalidKerasConfigurationException;
import org.deeplearning4j.nn.modelimport.keras.exceptions.UnsupportedKerasConfigurationException;
import org.deeplearning4j.nn.multilayer.MultiLayerNetwork;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.io.ClassPathResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.text.NumberFormat;
import java.util.List;

public class SaleAmountPrediction {

    private static final Logger log = LoggerFactory.getLogger(SaleAmountPrediction.class);

    private static int exampleLength = 50; // time series length, assume 22 working days per month

    public static void main (String[] args) throws IOException , InvalidKerasConfigurationException, UnsupportedKerasConfigurationException {
        String file = new ClassPathResource("SaleAmountData.csv").getFile().getAbsolutePath();
        int batchSize = 512; // mini-batch size
        double splitRatio = 0.9; // 90% for training, 10% for testing

        log.info("Create dataSet iterator...");

        SaleAmountDataSetIterator iterator = new SaleAmountDataSetIterator(file,  batchSize, exampleLength, splitRatio);
        log.info("Load test dataset...");
        List<Pair<INDArray, INDArray>> test = iterator.getTestDataSet();

        List<Double> origin = iterator.getOrigin();

        log.info("Load model...");
        MultiLayerNetwork net =
                org.deeplearning4j.nn.modelimport.keras.KerasModelImport.importKerasSequentialModelAndWeights
                        ("src/main/java/com/crm/deeplearning/model/model.json" ,
                                "src/main/java/com/crm/deeplearning/model/model.h5");

        log.info("Testing...");
        double max = iterator.getMaxArray();
        double min = iterator.getMinArray();
        predictPriceOneAhead(net, test, max, min,origin);

        log.info("Done...");
    }

    /** Predict one feature of a stock one-day ahead */
    private static void predictPriceOneAhead (MultiLayerNetwork net, List<Pair<INDArray, INDArray>> testData, double max, double min,List<Double> origin) {
//        System.err.println("Inside predict function:"+testData.size());
        double[] predicts = new double[testData.size()];
        double[] actuals = new double[testData.size()];
        for (int i = 0; i < testData.size(); i++) {
            predicts[i] = (net.rnnTimeStep(testData.get(i).getKey()).getDouble(exampleLength - 1) +1)* origin.get(origin.size()-(exampleLength+(testData.size()-i)));
            actuals[i] = (testData.get(i).getValue().getDouble(0) +1)* origin.get(origin.size()-(exampleLength+(testData.size()-i)));
        }
        log.info("Print out Predictions and Actual Values...");
        log.info("Predict,Actual");
        NumberFormat format = NumberFormat.getPercentInstance();
        format.setMaximumFractionDigits(2);//设置保留几位小数
        for (int i = 0; i < predicts.length; i++){
            log.info(predicts[i] + "," + actuals[i]+" -- 偏移比率："+format.format(Math.abs((actuals[i]-predicts[i])/actuals[i])));
        }
        log.info("Plot...");
        PlotUtil.plot(predicts, actuals,"Sale Amount");
    }
}