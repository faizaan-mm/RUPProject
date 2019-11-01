/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cityguideproject;
import static com.teamdev.jxbrowser.engine.RenderingMode.HARDWARE_ACCELERATED;

import com.teamdev.jxbrowser.browser.Browser;
import com.teamdev.jxbrowser.engine.Engine;
import com.teamdev.jxbrowser.engine.EngineOptions;
import com.teamdev.jxbrowser.view.swing.BrowserView;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
/**
 *
 * @author felixfaker
 */
public class TouristMap {
     public static void open_window() {
        System.setProperty("jxbrowser.license.key", "1BNDHFSC1FTJT23SGR915JHIXYTZFVEJF03DV9RXAT19GCNW7APR3P417WRETJRGRE2CFC");
        EngineOptions options =
                EngineOptions.newBuilder(HARDWARE_ACCELERATED).build();
        Engine engine = Engine.newInstance(options);
        Browser browser = engine.newBrowser();

        SwingUtilities.invokeLater(() -> {
            BrowserView view = BrowserView.newInstance(browser);

            JFrame frame = new JFrame("City Map");
            frame.add(view, BorderLayout.CENTER);
            frame.setSize(800, 500);
            frame.setVisible(true);
            
            browser.navigation().loadUrl("file://"+System.getProperty("user.dir")+"/src/cityguideproject/map.html");
        });
    }
}
