package sources;

import com.twitter.hbc.core.endpoint.StatusesFilterEndpoint;
import com.twitter.hbc.core.endpoint.StreamingEndpoint;
import org.apache.flink.streaming.connectors.twitter.TwitterSource;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public class TwitterUsersSource implements TwitterSource.EndpointInitializer, Serializable {

    private static final long TESLA = 13298072L;
    private static final long ELON_MUSK = 44196397L;
    private static final long CNN = 759251L;
    private static final long BLOOMBERG = 34713362L;
    private static final long THE_ECONOMIST = 5988062L;
    private static final long THE_TELEGRAPH = 16343974L;
    private static final long HANDELSBLATT = 2979574468L;
    private static final List<Long> USERS = Arrays.asList(TESLA,
            ELON_MUSK,
            CNN,
            BLOOMBERG,
            THE_ECONOMIST,
            THE_TELEGRAPH,
            HANDELSBLATT);

    public TwitterUsersSource() {}

    @Override
    public StreamingEndpoint createEndpoint() {
        StatusesFilterEndpoint endpoint = new StatusesFilterEndpoint();
        endpoint.followings(USERS);
        return endpoint;
    }
}
