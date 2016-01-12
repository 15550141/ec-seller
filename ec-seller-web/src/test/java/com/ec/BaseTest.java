package com.ec;

//import com.jd.swp.proxy.HumanService;
//import com.jd.swp.proxy.SWPProxyService;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * 测试Base类
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-config-test.xml" })
public class BaseTest {

    protected static ApplicationContext appContext;

    @BeforeClass
    public static void setUp() throws Exception {
//        try {
//            long start = System.currentTimeMillis();
//            System.out.println("正在加载配置文件...");
//
//            appContext = new ClassPathXmlApplicationContext("spring/spring-config-utils.xml");
//            System.out.println("配置文件加载完毕,耗时：" + (System.currentTimeMillis() - start));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

    public static void main(String[] args) {
        System.out.println(BaseTest.class.getResource("/"));
    }

    protected boolean setProtected() {
        return false;
    }

    @Before
    public void autoSetBean() {
//        appContext.getAutowireCapableBeanFactory().autowireBeanProperties(this, DefaultListableBeanFactory.AUTOWIRE_BY_NAME, false);
    }

    @AfterClass
    public static void tearDown() {

    }

//    @Test
//    public void test() {
//        HumanService safHumanService = (HumanService) appContext.getBean("safHumanService");
//        SWPProxyService swpSAFService = (SWPProxyService) appContext.getBean("swpSAFService");
//        String processId = "FBS_Vendor";
//        Map<String, Object> map = new HashMap<String, Object>();
//        map.put("firstAudit", "test");
//        String id = swpSAFService.startWorkflow(processId, String.valueOf(System.currentTimeMillis()), map);
//        System.out.println(id);
//    }

//    @Test
//    public void testRule() {
//        HumanService safHumanService = (HumanService) appContext.getBean("safHumanService");
//        SWPProxyService swpSAFService = (SWPProxyService) appContext.getBean("swpSAFService");
//
//        String aa = "devd-95270487-502d-11e4-81bd-002264082984";
//        String processInstanceId = "devd-94e2f6a2-502d-11e4-81bd-002264082984";
//        String processId = "FBS_Vendor";
//        String userId = "test";
//        String TASK_DEF_KEY_CAD = "audit_1";
//        String FIM_VENDOR_PROCESSID = "FIM_Vendor";
//
//        Map paras = new HashMap();
//        paras.put("taskDefinitionKey", TASK_DEF_KEY_CAD);
//        paras.put("processInstanceId", processInstanceId);
//        paras.put("start", 0);
//        paras.put("size", 20);
//        paras.put("sort", "createTime");
//        paras.put("order", "desc");
//        String msg = safHumanService.taskQuery(userId, "abcd1234", processId, paras);
//        System.out.println("--------------------------------------------------------");
//        System.out.println(msg);
//        System.out.println("--------------------------------------------------------");
//    }
}