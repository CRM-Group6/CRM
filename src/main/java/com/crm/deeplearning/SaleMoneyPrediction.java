package com.crm.deeplearning;

/**
 * Created by JackKo
 * 2018/8/17 9:37
 **/
import org.datavec.api.records.reader.RecordReader;
import org.datavec.api.records.reader.impl.csv.CSVRecordReader;
import org.datavec.api.split.FileSplit;
import org.datavec.api.util.ClassPathResource;
import org.deeplearning4j.datasets.datavec.RecordReaderDataSetIterator;
import org.deeplearning4j.eval.Evaluation;
import org.deeplearning4j.nn.multilayer.MultiLayerNetwork;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.dataset.DataSet;
import org.nd4j.linalg.dataset.api.iterator.DataSetIterator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/*
public class SaleMoneyPrediction {
    private static Logger log = LoggerFactory.getLogger(SaleMoneyPrediction.class);

    public static void main(String[] args) throws Exception {




        MultiLayerNetwork model =
                org.deeplearning4j.nn.modelimport.keras.KerasModelImport.importKerasSequentialModelAndWeights
                        ("model.json","model.h5");


        int numLinesToSkip = 0;//没有表头，所以不用跳过行数
        String delimiter = ",";
        // Read the iris.txt file as a collection of records
        RecordReader recordReader = new CSVRecordReader(numLinesToSkip,delimiter);//文件读取器
        recordReader.initialize(new FileSplit(new ClassPathResource("gzmt.csv").getFile());

        // label index
        int labelIndex = 4;
        // num of classes
        int numClasses = 3;
        // batchsize all
        int batchSize = 150;

        DataSetIterator iterator = new RecordReaderDataSetIterator(recordReader,batchSize,labelIndex,numClasses);

        DataSet allData = iterator.next();
        allData.shuffle();

        // Have our model
        //we have our Record Reader to read data
        // Evaluate the model

        Evaluation eval = new Evaluation(3);
        INDArray output = model.output(allData.getFeatureMatrix());
        eval.eval(allData.getLabels(),output);
        log.info(eval.stats());
    }

}
*/