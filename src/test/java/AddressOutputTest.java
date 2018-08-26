import org.json.JSONObject;
import org.junit.Test;
import utils.LoadProperties;
import utils.Regex;

import java.io.UnsupportedEncodingException;
import java.util.Objects;

public class AddressOutputTest {

    /**
     * This test is not exactly a test : this structure is used for showing the json result of the addresses
     * through a specific regular expression transformation.
     * The output (initial addresses) is found in addressInput.properties and the test will show the result for all the addresses
     *
     * Needed for the tests :
     *  - a Regex method : "getAddressFormated" for recognizing the housenumber and the street from the initial string
     *  - an "AddressObject" for making a structure to an address with its own street and its own housenumber
     *
     * Because of the ä (forth address), the text should be converted to UTF-8 (AddressInput.properties : is exactly a copy paste of addresses from the exercice)
     *
     * Inside the test, the jsonobject will be created in the wished format and ca be used as variable : jsonObject
     *
     * @throws UnsupportedEncodingException
     */
    @Test
    public void jsonFormatedAddressTest() throws UnsupportedEncodingException {
        for (int i = 1; i <= 9; i++) {
            String textToFormat = new LoadProperties("addressInput.properties").getPropValue("ad_"+i);
            String housenummer = Objects.requireNonNull(Regex.getAddressFormated(textToFormat)).housenummber;
            String street = Objects.requireNonNull(Regex.getAddressFormated(textToFormat)).street;
            JSONObject jsonObject = new JSONObject("{\"street\": \""+street+"\", \"housenumber\": \""+housenummer+"\"}");
            System.out.println(textToFormat+" ==> "+jsonObject);

            /**
             * N.B. The elements are not ordered as wished :
             You cannot and should not rely on the ordering of elements within a JSON object.
             From the JSON specification at http://www.json.org/:
             "An object is an unordered set of name/value pairs"
             As a consequence, JSON libraries are free to rearrange the order of the elements as they see fit. This is not a bug.
             */
        }
    }
}
