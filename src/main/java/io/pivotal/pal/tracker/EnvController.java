package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class EnvController {

    private String port;
    private String memoryLimit;
    private String cfInstanceIndex;
    private String cfInstanceAddr;


    public EnvController(@Value("${PORT:NOT SET}") String port, @Value("${MEMORY_LIMIT:NOT SET}")String memoryLimit
            , @Value("${CF_INSTANCE_INDEX:NOT SET}") String cfInstanceIndex, @Value("${CF_INSTANCE_ADDR:NOT SET}") String cfInstanceAddr) {
        this.port = port;
        this.memoryLimit = memoryLimit;
        this.cfInstanceIndex = cfInstanceIndex;
        this.cfInstanceAddr = cfInstanceAddr;
    }

    @GetMapping("/env")
    public Map<String, String> getEnv() throws Exception {
        Map<String, String> envDetails = new HashMap<>();

        envDetails.put("PORT", this.port);
        envDetails.put("MEMORY_LIMIT", this.memoryLimit);
        envDetails.put("CF_INSTANCE_INDEX", this.cfInstanceIndex);
        envDetails.put("CF_INSTANCE_ADDR", this.cfInstanceAddr);

        return envDetails;
    }
}
