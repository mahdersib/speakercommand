package org.comcast.speakercommand.model;

public class MostFrequentCommand {
    private String mostFrequentCommand;
    private long startProcessTime;
    private long stopProcessTime;

    public String getMostFrequentCommand() {
        return mostFrequentCommand;
    }

    public void setMostFrequentCommand(String mostFrequentCommand) {
        this.mostFrequentCommand = mostFrequentCommand;
    }

    public long getStartProcessTime() {
        return startProcessTime;
    }

    public void setStartProcessTime(long startProcessTime) {
        this.startProcessTime = startProcessTime;
    }

    public long getStopProcessTime() {
        return stopProcessTime;
    }

    public void setStopProcessTime(long stopProcessTime) {
        this.stopProcessTime = stopProcessTime;
    }
}
