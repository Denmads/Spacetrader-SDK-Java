package madsj;

import madsj.entities.GameInfo;
import madsj.entities.LeaderBoard;
import madsj.entities.Token;
import madsj.subapis.*;

import java.io.IOException;
import java.net.URISyntaxException;

public class SpaceTrader {

    public AccountAPI Account;
    public SystemAPI Systems;

    private GameAPI gameAPI;
    private LeaderBoardAPI leaderBoardAPI;

    private SpaceTrader(String token) {
        ApiCaller caller = new ApiCaller(token);

        Account = new AccountAPI(caller);
        Systems = new SystemAPI(caller);

        leaderBoardAPI = new LeaderBoardAPI(caller);
        gameAPI = new GameAPI(new ApiCaller());
    }

    public GameInfo getGameInfo() throws InterruptedException, IOException, URISyntaxException {
        return gameAPI.getGameInfo();
    }

    public LeaderBoard getLeaderBoard() throws InterruptedException, IOException, URISyntaxException {
        return leaderBoardAPI.getLeaderBoard();
    }

    static class Builder {
        private String info = null;
        private boolean claim = false;

        public Builder token(String token) {
            info = token;
            return this;
        }

        public Builder username(String username) {
            info = username;
            claim = true;
            return this;
        }

        public SpaceTrader build() throws Exception {
            if (info == null) {
                throw new Exception("Please call 'token()' or 'username()' before build!");
            }

            if (claim) {
                Token token = new UserAPI(new ApiCaller()).createUser(info);
                return new SpaceTrader(token.token);
            }
            else {
                return new SpaceTrader(info);
            }
        }
    }
}
