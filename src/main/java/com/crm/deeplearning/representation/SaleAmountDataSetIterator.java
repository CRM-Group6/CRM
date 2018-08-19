package com.crm.deeplearning.representation;

/**
 * Created by JackKo
 * 2018/8/17 10:53
 **/

import com.opencsv.CSVReader;
import javafx.util.Pair;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.dataset.DataSet;
import org.nd4j.linalg.dataset.api.DataSetPreProcessor;
import org.nd4j.linalg.dataset.api.iterator.DataSetIterator;
import org.nd4j.linalg.factory.Nd4j;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class SaleAmountDataSetIterator implements DataSetIterator {

    private int miniBatchSize; // mini-batch size
    private int exampleLength = 22; // default 22, say, 22 working days per month
    private int predictLength = 1; // default 1, say, one day ahead prediction

    /** minimal values of each feature in stock dataset */
    private double minArray;
    /** maximal values of each feature in stock dataset */
    private double maxArray ;

    /** mini-batch offset */
    private LinkedList<Integer> exampleStartOffsets = new LinkedList<>();

    /** stock dataset for training */
    private List<SaleAmountData> train;
    /** adjusted stock dataset for testing */
    private List<Pair<INDArray, INDArray>> test;

    private List<Double> origin;


    private List<Pair<INDArray, INDArray>> test50;

    public SaleAmountDataSetIterator(String filename, int miniBatchSize, int exampleLength, double splitRatio) {
        origin = new ArrayList<>();
        List<SaleAmountData> saleAmountDataList = readStockDataFromFile(filename);
        this.miniBatchSize = miniBatchSize;
        this.exampleLength = exampleLength;
        int split = (int) Math.round(saleAmountDataList.size() * splitRatio);
        train = saleAmountDataList.subList(0, split);
        test = generateTestDataSet(saleAmountDataList.subList(split, saleAmountDataList.size()));
        test50 = new ArrayList<>();
        System.err.println("总的数据量 = "+ saleAmountDataList.size()
                + "\n" + "用于训练的数据量 = " + train.size()
                + "\n" + "用于测试的数据量 = " + test.size());
        initializeOffsets();
    }

    /** initialize the mini-batch offsets */
    private void initializeOffsets () {
        exampleStartOffsets.clear();
        int window = exampleLength + predictLength;
        for (int i = 0; i < train.size() - window; i++) { exampleStartOffsets.add(i); }
    }

    public List<Pair<INDArray, INDArray>> getTestDataSet() { return test; }

    public double getMaxArray() { return maxArray; }

    public double getMinArray() { return minArray; }

    @Override
    public DataSet next(int num) {
       /* if (exampleStartOffsets.size() == 0) throw new NoSuchElementException();
        int actualMiniBatchSize = Math.min(num, exampleStartOffsets.size());
        INDArray input = Nd4j.create(new int[] {actualMiniBatchSize, VECTOR_SIZE, exampleLength}, 'f');
        INDArray label;
        if (category.equals(PriceCategory.ALL)) label = Nd4j.create(new int[] {actualMiniBatchSize, VECTOR_SIZE, exampleLength}, 'f');
        else label = Nd4j.create(new int[] {actualMiniBatchSize, predictLength, exampleLength}, 'f');
        for (int index = 0; index < actualMiniBatchSize; index++) {
            int startIdx = exampleStartOffsets.removeFirst();
            int endIdx = startIdx + exampleLength;
            SaleAmountData curData = train.get(startIdx);
            SaleAmountData nextData;
            for (int i = startIdx; i < endIdx; i++) {
                int c = i - startIdx;
                input.putScalar(new int[] {index, 0, c}, (curData.getOpen() - minArray[0]) / (maxArray[0] - minArray[0]));
                input.putScalar(new int[] {index, 1, c}, (curData.getClose() - minArray[1]) / (maxArray[1] - minArray[1]));
                input.putScalar(new int[] {index, 2, c}, (curData.getLow() - minArray[2]) / (maxArray[2] - minArray[2]));
                input.putScalar(new int[] {index, 3, c}, (curData.getHigh() - minArray[3]) / (maxArray[3] - minArray[3]));
                input.putScalar(new int[] {index, 4, c}, (curData.getVolume() - minArray[4]) / (maxArray[4] - minArray[4]));
                nextData = train.get(i + 1);
                if (category.equals(PriceCategory.ALL)) {
                    label.putScalar(new int[] {index, 0, c}, (nextData.getOpen() - minArray[1]) / (maxArray[1] - minArray[1]));
                    label.putScalar(new int[] {index, 1, c}, (nextData.getClose() - minArray[1]) / (maxArray[1] - minArray[1]));
                    label.putScalar(new int[] {index, 2, c}, (nextData.getLow() - minArray[2]) / (maxArray[2] - minArray[2]));
                    label.putScalar(new int[] {index, 3, c}, (nextData.getHigh() - minArray[3]) / (maxArray[3] - minArray[3]));
                    label.putScalar(new int[] {index, 4, c}, (nextData.getVolume() - minArray[4]) / (maxArray[4] - minArray[4]));
                } else {
                    label.putScalar(new int[]{index, 0, c}, feedLabel(nextData));
                }
                curData = nextData;
            }
            if (exampleStartOffsets.size() == 0) break;
        }
        return new DataSet(input, label);
        */
       return null;
    }

    private double feedLabel(SaleAmountData data) {
        /*
        double value;

        switch (category) {
            case OPEN: value = (data.getOpen() - minArray[0]) / (maxArray[0] - minArray[0]); break;
            case CLOSE: value = (data.getClose() - minArray[1]) / (maxArray[1] - minArray[1]); break;
            case LOW: value = (data.getLow() - minArray[2]) / (maxArray[2] - minArray[2]); break;
            case HIGH: value = (data.getHigh() - minArray[3]) / (maxArray[3] - minArray[3]); break;
            case VOLUME: value = (data.getVolume() - minArray[4]) / (maxArray[4] - minArray[4]); break;
            default: throw new NoSuchElementException();
        }
        return value;
        */
        return 0;
    }

 //   @Override public int totalExamples() { return train.size() - exampleLength - predictLength; }

    @Override public int inputColumns() { return 1; }

    @Override public int totalOutcomes() {

              return predictLength;
    }

    @Override public boolean resetSupported() { return false; }

    @Override public boolean asyncSupported() { return false; }

    @Override public void reset() { initializeOffsets(); }

    @Override public int batch() { return miniBatchSize; }

//    @Override public int cursor() { return totalExamples() - exampleStartOffsets.size(); }

//    @Override public int numExamples() { return totalExamples(); }

    @Override public void setPreProcessor(DataSetPreProcessor dataSetPreProcessor) {
        throw new UnsupportedOperationException("Not Implemented");
    }

    @Override public DataSetPreProcessor getPreProcessor() { throw new UnsupportedOperationException("Not Implemented"); }

    @Override public List<String> getLabels() { throw new UnsupportedOperationException("Not Implemented"); }

    @Override public boolean hasNext() { return exampleStartOffsets.size() > 0; }

    @Override public DataSet next() { return next(miniBatchSize); }

    private List<Pair<INDArray, INDArray>> generateTestDataSet (List<SaleAmountData> saleAmountDataList) {
        int window = exampleLength + predictLength;
        List<Pair<INDArray, INDArray>> test = new ArrayList<>();
        for (int i = 0; i < saleAmountDataList.size() - window; i++) {
            INDArray input = Nd4j.create(new int[] {exampleLength, 1}, 'f');
            double firstItemInWin=saleAmountDataList.get(i).getSaleMoney();
            for (int j = i; j < i + exampleLength; j++) {

                SaleAmountData stock = saleAmountDataList.get(j);
                input.putScalar(new int[] {j - i , 0}, (stock.getSaleMoney()/firstItemInWin)-1);
            }
            SaleAmountData stock = saleAmountDataList.get(i + exampleLength);

            INDArray label; //设置第51个为标签
            label = Nd4j.create(new int[] {1}, 'f'); //创建矩阵大小为1*1
            label.putScalar(new int[] {0}, (stock.getSaleMoney()/firstItemInWin)-1);

            test.add(new Pair<>(input, label));
        }
        return test;
    }

    private List<SaleAmountData> readStockDataFromFile (String filename) {
        List<SaleAmountData> saleAmountDataList = new ArrayList<>();
        try {
            // initialize max and min arrays
                maxArray = Double.MIN_VALUE;
                minArray = Double.MAX_VALUE;

            List<String[]> list = new CSVReader(new FileReader(filename)).readAll(); // load all elements in a list
            for (String[] arr : list) {
                double num ;
                num = Double.valueOf(arr[1]);
                if (num > maxArray) maxArray = num;
                if (num < minArray) minArray = num;

                saleAmountDataList.add(new SaleAmountData(arr[0],  num));
                origin.add(num);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return saleAmountDataList;
    }

    public List<Pair<INDArray, INDArray>> getTest50() {
        return test50;
    }

    public List<Double> getOrigin() {
        return origin;
    }
}
