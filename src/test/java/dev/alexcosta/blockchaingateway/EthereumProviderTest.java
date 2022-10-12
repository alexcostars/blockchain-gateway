package dev.alexcosta.blockchaingateway;

import dev.alexcosta.blockchaingateway.provider.EthereumProvider;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

public class EthereumProviderTest {

    @Test
    public void connection() {
        EthereumProvider ep = new EthereumProvider();
        Assert.notNull(ep, "Ok");
    }
}
