# MobileAutomationFramework

Test Driven Framework developed using Java with TestNG, Extent Reports.

Can work on both android, ios including physical devices, emulators.

How to use this framework?

1. Clone the repository to your workspace.
2. Open the testdata.xlsx under the src/test/resources folder
3. In the RunManager sheet -->Choose the test cases you want to run by choosing yes
4. In the testdata sheet --->Choose the test data you want to pass to the testcase from excel sheet.
5. The data from the excel sheet will be passed to the test method as a hashtable.
6. Run the testng.xml file. You can even run as mvn test which will trigger the testng.xml

How the framework works?

1. AnnotationTransformer class which implements IAnnotationTransformer is reponsible for reading the data from RunManager sheet in testdata.xlsx
   It sets the annotation of the test methods like description,enabled, priority, dataprovider values read from the excel.
   
   Things to note : Test name in the first column of the excel sheet should match with atleast an @Test available in test classes mentioned in the testng.xml
   
2. All the tests will have the same dataprovider in the TestUtils class. For example the loginTest in RunManager sheet of testdata.xlsx will take the data from 
   TestData sheet which have row where the testname is loginTest. If there are multiple rows with loginTest as test name , framework will consider it as
   this as multiple iterations for a test case.
   
How to run on different mobile devices or emulators?

1. Type adb devices in the cmd(Make sure adb is installed and path set correctly) and update the values generated in the udid column of TestData sheet in testdata.xlsx
2. Device name can be anything but not null(Used to denote the device where you are running the test like MyS9Device)
3. Port is used for parallel execution. If there are two different ports used and testng threadcount is two ,then two tests will be run in parallel.
4. You can use more ports if you want to increase the parallel execution count.

Other tips:

1. TestCase description given in the excel sheet will be displayed in the extent reports.
2. Reusable methods are placed in BasePage.java and can be utilised in your tests.
3. Data from excel sheet will be available as Hashtable parameter to your tests. You can fetch the value using data.get("columnnameinexcel")
   Refer the already existing tests for more details.
4. Make sure that your appium server is up and running before starting the tests.

Please feel to report any issue or PR for any improvements.
Reach me at mech.amuthansakthivel@gmail.com
