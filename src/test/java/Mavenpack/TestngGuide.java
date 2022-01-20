package Mavenpack;

public class TestngGuide {

	public static void main(String[] args) {
		/* Annotation list on TestNG
		 =====
		 @Test
		 @BeforeMethod
		 @AfterMethod
		 @BeforeTest
		 @AfterTest
		 @BeforeSuit
		 @AfterSuit
		 @BeforeClass
		 @Afterclass

 TestNG Reports =Under test-output folder > index.html ,  Refresh the Project and view the TestNG report generated at 'test-output' > old > index.html

//If we want to manually throw any exception based on some condition, we have to use throw 
		 package throwPackDemo;
 public class ThrowDemo {
		 	public static void main(String args[]) throws Exception {
		 	int a = 5,b = 6;
		 	if(a<b) {
		 		  throw new Exception();	
		 			}}}
====================================================================================
//If we want to manually skip any test method in TestNG, we have to use throw
		 package skipPack;

		 import org.testng.SkipException;
		 import org.testng.annotations.Test;

		 public class Demo {
		 	
		 	@Test
		 	public void testLogin() {
		 		
		 		int a = 5,b=6;
		 	
		 		if(a<b) {
		 			throw new SkipException("Skipping test in TestNG");
		 		}}}
========================================================================================
TestNG Assertions 
AssertEquals()
assertTrue()
assertFalse()
Fail()
=========================================================================================
 //Demonstrate a program which uses assertEquals() to verify a failing test - 
		 package assertionsDemo;

		 import org.testng.Assert;
		 import org.testng.annotations.Test;

		 public class testNGAssertionsDemoOne {

		 	@Test
		 	public void sampleMethod(){
		 		
		 		Assert.assertEquals("Hello", "Bye"); }}
		 	
=============================================================================================		 	
	priority attribute of @Test annotation is used to prioritize the tests
	@Test(priority=1)
============================================================================================
o	Create a testng.xml file in the Project and execute all the classes at a go using testng.xml file
	Right click on the Project > Select TestNG > Convert To TestNG
=============================================================================================
•	Commenting in testng.xml file
•	Excluding a method from execution by changing the testng.xml file
o	<class name="demopack.DemoMavenProject.Demo">  <methods> <exclude name="demoMethodTwo"/>  </methods> </class>
•	Or, we can include a specific method that only needs to executed by changing the testng.xml file
o	<class name="demopack.DemoMavenProject.Demo">  <methods> <include name="demoMethodTwo"/>  </methods> </class>
•	Exclude or include with regular expressions
o	<class name="demopack.DemoMavenProject.Demo">  <methods> <include name="demo.*"/>  </methods> </class>
•	Executing the tests at package level
o	Under test tags, specify the package name - <test> <packages> <package  name="xyz"/></packages> </test>
========================================================================================================================
•	Groups
o	include a group 

<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd">
<suite name="payments">
<test name="smoketests"> 
  <groups>
     <run>
     <include name="smoke"/>
     </run>
  </groups>
  
  <classes>
    <class name="demopack.DemoMavenProject.Demo" />
   <class name="demopack.DemoMavenProject.DemoTwo" />
   <class name="demopack.DemoMavenProject.DemoThree" />
  </classes>

</test>		 

	o	exclude a group (Simply change include to exclude in the above example here)
o	@Test(groups={"smoke"})

========================================================================		 	
o	dependsOnMethods - before executing the test, the dependent tests will be executed 
public class Demo {
	
	@Test
	public void flipkart() {
		System.out.println("Flipkart"); }
	
	@Test(dependsOnMethods= {"flipkart","walmart"})
	public void amazon() {
		System.out.println("Amazon");}
	
	@Test(enabled=false) =   enabled=false to stop it from executing
	public void macys() {
		
		System.out.println("Macys");}
	
	@Test(timeOut=5000)
	public void walmart() throws InterruptedException {
		
		Thread.sleep(4000);
		System.out.println("Walmart");}}	 	
		 	
//=========================================================================================Testng.xml Parameterization		 	
	<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd">
<suite name="payments">

<parameter name="URL" value="http://omayo.blogspot.com/" />

<test name="testsA"> 
<parameter name="URL" value="http://tutorialsninja.com/demo/" />
  <classes>
   <class name="demopack.DemoMavenProject.DemoTwo" />
   <class name="demopack.DemoMavenProject.DemoThree" />
  </classes> 
</test> 

<test name="testsB"> 
  <classes>
 <class name="demopack.DemoMavenProject.Demo" />
  </classes> 
</test> 

</suite> <!-- Suite -->	 	
=============================================================================================================================		 	
Data driven Testing = Single test case will be driven by multiple data
public class Demo {
@Test(dataProvider="getData")
public void flipkart(String username,String password) {
		System.out.println("Flipkart - "+username+" and "+password);
		
	}
	
	@DataProvider
	public Object[][] getData() {
		
		Object[][] data = new Object[3][2];
		
		data[0][0] = "arunmotoori";
		data[0][1] = "12345";
		
		data[1][0] = "varun";
		data[1][1] = "6789";
		
		data[2][0] = "tharun";
		data[2][1] = "1111";
		
		return data;       }} 	
=======================================================================================================================	
* TestNG Listeners
  * Listeners listen to our code and perform necessary actions like taking screenshots, failing tests etc. 
  *Add the required methods of ITestListener interface 	 	
public class Listeners implements ITestListener {

	public void onTestStart(ITestResult result) {
		System.out.println("Listened to code and found that the Test started "+result.getName());	
		}
	
	public void onTestSuccess(ITestResult result) {
		System.out.println("Listened to code and found that it is successfully executed "+result.getName());
		}
	
	public void onTestFailure(ITestResult result) {
		System.out.println("Listened to code and found that the Test is failed "+result.getName());
		}
	
	public void onTestSkipped(ITestResult result) {
		System.out.println("Listened to code and found that the Test is skipped "+result.getName());
		}}
	
========================Add the Listeners tags below the suite tag in testng.xml file
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd">
<suite name="payments">
  <listeners>
     <listener class-name="demopack.DemoMavenProject.Listeners" />
  </listeners>
<test name="testsA"> 
  <classes>
   <class name="demopack.DemoMavenProject.DemoThree" />
  </classes> 

</test> 
</suite> <!-- Suite -->
========================================================================================================================		
		•	TestNG - Parallel Execution of Tests at test level and suite level
o	parallel="methods" thread-count="2" (Add this in the test tag)
o	parallel="methods" thread-count="2" (Add this in the suite tag)
=================================================================================================
		
		
		
		
		 	*/
	}}
