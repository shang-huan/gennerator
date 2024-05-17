import freemarker.template.*;
import org.junit.Test;

import java.util.*;
import java.io.*;

public class FreeMarkerTest {

    @Test
    public void testFreeMarker() throws Exception {

        /* ------------------------------------------------------------------------ */
        /* You should do this ONLY ONCE in the whole application life-cycle:        */

        /* Create and adjust the configuration singleton */
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_22);
        String filePath = System.getProperty("user.dir")+File.separator+"src/main/resources/templates";
        // 设置模版加载目录
        cfg.setDirectoryForTemplateLoading(new File(filePath));
        // 设置编码模式
        cfg.setDefaultEncoding("UTF-8");

        /* ------------------------------------------------------------------------ */
        /* You usually do these for MULTIPLE TIMES in the application life-cycle:   */

        /* Create a data-model */
        Map<String,Object> root = new HashMap<>();
        root.put("user", "Big Joe");
        Map latest = new HashMap();
        root.put("latestProduct", latest);
        latest.put("url", "products/greenmouse.html");
        latest.put("name", "green mouse");

        /* Get the template (uses cache internally) */
        Template temp = cfg.getTemplate("test.html.ftl");

        /* Merge data-model with template */
        // 输出到系统打印
        Writer out = new OutputStreamWriter(System.out);
        temp.process(root, out);
        // Note: Depending on what `out` is, you may need to call `out.close()`.
        // This is usually the case for file output, but not for servlet output.
    }
}
