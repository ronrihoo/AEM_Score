package aemscore.drivers;

import aemscore.computation.Data;
import aemscore.computation.Statistics;
import aemscore.computation.Grader;
import aemscore.io.FakeInterface;

/**
 * Holds all instances under the Drivers class.
 */
public class Instances {

    // Core functionality
    Data data = new Data();
    Statistics statistics = new Statistics();
    Grader grader = new Grader();

    // User-interface (input/output)
    FakeInterface fakeInterface = new FakeInterface();

    public Instances() {

    }

    // Getters

    public Data getDataSets() {
        return data;
    }

    public Statistics getStatistics() {
        return statistics;
    }

    public Grader getGrader() {
        return grader;
    }

    public FakeInterface getFakeInterface() {
        return fakeInterface;
    }

    // Setters

    public void setDataSets(Data data) {
        this.data = data;
    }

    public void setStatistics(Statistics statistics) {
        this.statistics = statistics;
    }

    public void setGrader(Grader grader) {
        this.grader = grader;
    }

    public void setFakeInterface(FakeInterface fakeInterface) {
        this.fakeInterface = fakeInterface;
    }

}
