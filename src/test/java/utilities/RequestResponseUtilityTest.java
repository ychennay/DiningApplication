package test.java.utilities;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import main.java.implementations.YelpServiceImplementation;
import main.java.utilities.RequestResponseUtility;
import oracle.jrockit.jfr.events.RequestableEventEnvironment;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.mockito.Mock;

import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.springframework.boot.test.context.SpringBootTest;
import test.java.AbstractTest;

import java.io.IOException;
import java.io.InputStream;
import java.rmi.server.ExportException;

/**
 * Created by ychen4 on 5/26/2017.
 * This test class will test the utility functions
 */
@SpringBootTest(classes = RequestResponseUtility.class)
public class RequestResponseUtilityTest extends AbstractTest {

    @Mock
    private InputStream inputStream;

    @Rule public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Rule public ExpectedException thrown = ExpectedException.none();

    /**
     * This test function makes sure a call to convert a Stream to String does not throw IOExceptions
     * @throws IOException
     */
    @Test(expected = IOException.class)
    public void convertStreamToStringNullTest() throws IOException {

        String result = RequestResponseUtility.convertStreamToString(inputStream);
        Assert.assertFalse(result.isEmpty());
    }

    /**
     * This test function makes sure a call to convert a Stream to Json does not throw IOExceptions
     * @throws IOException
     */
    @Test(expected = IOException.class)
    public void convertStreamToJsonNullTest() throws IOException {
        RequestResponseUtility.convertStreamToJson(inputStream);

    }
}
