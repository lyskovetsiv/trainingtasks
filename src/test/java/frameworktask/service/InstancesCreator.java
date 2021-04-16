package frameworktask.service;

import frameworktask.models.Instances;

public class InstancesCreator {

    public static final String TESTDATA_NUMBER_OF_INSTANCES = "testdata.instances.numberofinstances";
    public static final String TESTDATA_WHAT_ARE_THESE_INSTANCES_FOR = "testdata.instances.whatarethisinstancesfor";
    private static final String TESTDATA_OPERATING_SYSTEM  = "testdata.instances.operatingsystem";
    private static final String TESTDATA_MACHINE_CLASS = "testdata.instances.machineclass";
    private static final String TESTDATA_MACHINE_FAMILY = "testdata.instances.machinefamily";
    private static final String TESTDATA_SERIES = "testdata.instances.series";
    private static final String TESTDATA_MACHINE_TYPE = "testdata.instances.machinetype";
    private static final String TESTDATA_NUMBER_OF_GPUS = "testdata.instances.numberofgpus";
    private static final String TESTDATA_GPU_TYPE = "testdata.instances.gputype";
    private static final String TESTDATA_LOCAL_SSD = "testdata.instances.localssd";
    private static final String TESTDATA_DATACENTER_LOCATION = "testdata.instances.datacenterlocation";
    private static final String TESTDATA_COMMITTED_USAGE = "testdata.instances.committedusage";

    public static Instances withFieldsFromProperty(){
        return new Instances(TestDataReader.getTestData(TESTDATA_NUMBER_OF_INSTANCES),
                TestDataReader.getTestData(TESTDATA_WHAT_ARE_THESE_INSTANCES_FOR), TestDataReader.getTestData(TESTDATA_OPERATING_SYSTEM),
                TestDataReader.getTestData(TESTDATA_MACHINE_CLASS),TestDataReader.getTestData(TESTDATA_MACHINE_FAMILY),
                TestDataReader.getTestData(TESTDATA_SERIES), TestDataReader.getTestData(TESTDATA_MACHINE_TYPE), TestDataReader.getTestData(TESTDATA_NUMBER_OF_GPUS),
                TestDataReader.getTestData(TESTDATA_GPU_TYPE), TestDataReader.getTestData(TESTDATA_LOCAL_SSD),
                TestDataReader.getTestData(TESTDATA_DATACENTER_LOCATION), TestDataReader.getTestData(TESTDATA_COMMITTED_USAGE));
    }
}
