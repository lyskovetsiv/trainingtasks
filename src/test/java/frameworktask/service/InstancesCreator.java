package frameworktask.service;

import frameworktask.models.Instance;

public class InstancesCreator {

    public static final String TESTDATA_NUMBER_OF_INSTANCES = "testdata.instance.numberofinstances";
    public static final String TESTDATA_WHAT_ARE_THESE_INSTANCES_FOR = "testdata.instance.whatarethisinstancesfor";
    private static final String TESTDATA_OPERATING_SYSTEM  = "testdata.instance.operatingsystem";
    private static final String TESTDATA_MACHINE_CLASS = "testdata.instance.machineclass";
    private static final String TESTDATA_MACHINE_FAMILY = "testdata.instance.machinefamily";
    private static final String TESTDATA_SERIES = "testdata.instance.series";
    private static final String TESTDATA_MACHINE_TYPE = "testdata.instance.machinetype";
    private static final String TESTDATA_NUMBER_OF_GPUS = "testdata.instance.numberofgpus";
    private static final String TESTDATA_GPU_TYPE = "testdata.instance.gputype";
    private static final String TESTDATA_LOCAL_SSD = "testdata.instance.localssd";
    private static final String TESTDATA_DATACENTER_LOCATION = "testdata.instance.datacenterlocation";
    private static final String TESTDATA_COMMITTED_USAGE = "testdata.instance.committedusage";

    public static Instance withFieldsFromProperty(){
        return new Instance(TestDataReader.getTestData(TESTDATA_NUMBER_OF_INSTANCES),
                TestDataReader.getTestData(TESTDATA_WHAT_ARE_THESE_INSTANCES_FOR), TestDataReader.getTestData(TESTDATA_OPERATING_SYSTEM),
                TestDataReader.getTestData(TESTDATA_MACHINE_CLASS),TestDataReader.getTestData(TESTDATA_MACHINE_FAMILY),
                TestDataReader.getTestData(TESTDATA_SERIES), TestDataReader.getTestData(TESTDATA_MACHINE_TYPE), TestDataReader.getTestData(TESTDATA_NUMBER_OF_GPUS),
                TestDataReader.getTestData(TESTDATA_GPU_TYPE), TestDataReader.getTestData(TESTDATA_LOCAL_SSD),
                TestDataReader.getTestData(TESTDATA_DATACENTER_LOCATION), TestDataReader.getTestData(TESTDATA_COMMITTED_USAGE));
    }
}
