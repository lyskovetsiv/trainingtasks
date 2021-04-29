package frameworktask.models;

import java.util.Objects;

public class Instance {
    private String numberOfInstances;
    private String whatAreTheseInstancesFor;
    private String operatingSystem;
    private String machineClass;
    private String machineFamily;
    private String series;
    private String machineType;
    private String numberOfGPUs;
    private String gpuType;
    private String localSSD;
    private String datacenterLocation;
    private String committedUsage;

    public Instance(String numberOfInstances, String whatAreTheseInstancesFor, String operatingSystem, String machineClass, String machineFamily, String series,
                    String machineType, String numberOfGPUs, String gpuType, String localSSD, String datacenterLocation, String committedUsage) {
        this.numberOfInstances = numberOfInstances;
        this.whatAreTheseInstancesFor = whatAreTheseInstancesFor;
        this.operatingSystem = operatingSystem;
        this.machineClass = machineClass;
        this.machineFamily = machineFamily;
        this.series = series;
        this.machineType = machineType;
        this.numberOfGPUs = numberOfGPUs;
        this.gpuType = gpuType;
        this.localSSD = localSSD;
        this.datacenterLocation = datacenterLocation;
        this.committedUsage = committedUsage;
    }

    public String getNumberOfInstances() {
        return numberOfInstances;
    }

    public void setNumberOfInstances(String numberOfInstances) {
        this.numberOfInstances = numberOfInstances;
    }

    public String getWhatAreTheseInstancesFor() {
        return whatAreTheseInstancesFor;
    }

    public void setWhatAreTheseInstancesFor(String whatAreTheseInstancesFor) {
        this.whatAreTheseInstancesFor = whatAreTheseInstancesFor;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public String getMachineClass() {
        return machineClass;
    }

    public void setMachineClass(String machineClass) {
        this.machineClass = machineClass;
    }


    public String getMachineFamily() {
        return machineFamily;
    }

    public void setMachineFamily(String machineFamily) {
        this.machineFamily = machineFamily;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getMachineType() {
        return machineType;
    }

    public void setMachineType(String machineType) {
        this.machineType = machineType;
    }

    public String getNumberOfGPUs() {
        return numberOfGPUs;
    }

    public void setNumberOfGPUs(String numberOfGPUs) {
        this.numberOfGPUs = numberOfGPUs;
    }

    public String getGpuType() {
        return gpuType;
    }

    public void setGpuType(String gpuType) {
        this.gpuType = gpuType;
    }

    public String getLocalSSD() {
        return localSSD;
    }

    public void setLocalSSD(String localSSD) {
        this.localSSD = localSSD;
    }

    public String getDatacenterLocation() {
        return datacenterLocation;
    }

    public void setDatacenterLocation(String datacenterLocation) {
        this.datacenterLocation = datacenterLocation;
    }

    public String getCommittedUsage() {
        return committedUsage;
    }

    public void setCommittedUsage(String committedUsage) {
        this.committedUsage = committedUsage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Instance)) return false;
        Instance instance = (Instance) o;
        return Objects.equals(numberOfInstances, instance.numberOfInstances) &&
                Objects.equals(whatAreTheseInstancesFor, instance.whatAreTheseInstancesFor) &&
                Objects.equals(operatingSystem, instance.operatingSystem) &&
                Objects.equals(machineClass, instance.machineClass) &&
                Objects.equals(machineFamily, instance.machineFamily) &&
                Objects.equals(series, instance.series) &&
                Objects.equals(machineType, instance.machineType) &&
                Objects.equals(numberOfGPUs, instance.numberOfGPUs) &&
                Objects.equals(gpuType, instance.gpuType) &&
                Objects.equals(localSSD, instance.localSSD) &&
                Objects.equals(datacenterLocation, instance.datacenterLocation) &&
                Objects.equals(committedUsage, instance.committedUsage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberOfInstances, whatAreTheseInstancesFor, operatingSystem, machineClass, machineFamily, series,
                machineType, numberOfGPUs, gpuType, localSSD, datacenterLocation, committedUsage);
    }
}
