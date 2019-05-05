package com.devanhurst.dondbriefcase.briefcase;

import java.util.Random;
import com.devanhurst.dondbriefcase.R;

public class Case {
    private Value[] values;
    private Random generator = new Random();
    private Integer[] bgmTracks;
    private String gameName;

    public Case(Integer gameId) {
        this.bgmTracks = new Integer[4];
        this.bgmTracks[0] = R.raw.thinkloop;
        this.bgmTracks[1] = R.raw.thinkloop2;
        this.bgmTracks[2] = R.raw.thinkloop3;
        this.bgmTracks[3] = R.raw.thinkloop4;

        switch (Math.abs(gameId) % 10) {
            case 0:
                this.gameName = "Classic (High bad)";

                this.values = new Value[26];
                this.values[0] = new Value("$1,000,000", R.raw.bad);
                this.values[1] = new Value("$750,000", R.raw.bad);
                this.values[2] = new Value("$500,000", R.raw.bad);
                this.values[3] = new Value("$400,000", R.raw.bad);
                this.values[4] = new Value("$300,000", R.raw.bad);
                this.values[5] = new Value("$200,000", R.raw.bad);
                this.values[6] = new Value("$100,000", R.raw.bad);
                this.values[7] = new Value("$75,000", R.raw.nothing);
                this.values[8] = new Value("$50,000", R.raw.nothing);
                this.values[9] = new Value("$25,000", R.raw.nothing);
                this.values[10] = new Value("$10,000", R.raw.nothing);
                this.values[11] = new Value("$5,000", R.raw.nothing);
                this.values[12] = new Value("$1,000", R.raw.nothing);
                this.values[13] = new Value("$750", R.raw.good);
                this.values[14] = new Value("$500", R.raw.good);
                this.values[15] = new Value("$400", R.raw.good);
                this.values[16] = new Value("$300", R.raw.good);
                this.values[17] = new Value("$200", R.raw.good);
                this.values[18] = new Value("$100", R.raw.good);
                this.values[19] = new Value("$75", R.raw.good);
                this.values[20] = new Value("$50", R.raw.good);
                this.values[21] = new Value("$25", R.raw.good);
                this.values[22] = new Value("$10", R.raw.good);
                this.values[23] = new Value("$5", R.raw.good);
                this.values[24] = new Value("$1", R.raw.good);
                this.values[25] = new Value("$0.01", R.raw.good);
                break;

            case 1:
                this.gameName = "Classic (High good)";

                this.values = new Value[26];
                this.values[0] = new Value("$1,000,000", R.raw.good);
                this.values[1] = new Value("$750,000", R.raw.good);
                this.values[2] = new Value("$500,000", R.raw.good);
                this.values[3] = new Value("$400,000", R.raw.good);
                this.values[4] = new Value("$300,000", R.raw.good);
                this.values[5] = new Value("$200,000", R.raw.good);
                this.values[6] = new Value("$100,000", R.raw.good);
                this.values[7] = new Value("$75,000", R.raw.nothing);
                this.values[8] = new Value("$50,000", R.raw.nothing);
                this.values[9] = new Value("$25,000", R.raw.nothing);
                this.values[10] = new Value("$10,000", R.raw.nothing);
                this.values[11] = new Value("$5,000", R.raw.nothing);
                this.values[12] = new Value("$1,000", R.raw.nothing);
                this.values[13] = new Value("$750", R.raw.nothing);
                this.values[14] = new Value("$500", R.raw.nothing);
                this.values[15] = new Value("$400", R.raw.bad);
                this.values[16] = new Value("$300", R.raw.bad);
                this.values[17] = new Value("$200", R.raw.bad);
                this.values[18] = new Value("$100", R.raw.bad);
                this.values[19] = new Value("$75", R.raw.bad);
                this.values[20] = new Value("$50", R.raw.bad);
                this.values[21] = new Value("$25", R.raw.bad);
                this.values[22] = new Value("$10", R.raw.bad);
                this.values[23] = new Value("$5", R.raw.bad);
                this.values[24] = new Value("$1", R.raw.bad);
                this.values[25] = new Value("$0.01", R.raw.bad);
                break;

            case 2:
                this.gameName = "Double or Nothing";

                this.values = new Value[2];
                this.values[0] = new Value("NOTHING", R.raw.bad);
                this.values[1] = new Value("DOUBLE", R.raw.good);

                this.bgmTracks = new Integer[1];
                this.bgmTracks[0] = R.raw.bankoffer;
                break;

            case 3:
                this.gameName = "10 Candies";

                this.values = new Value[4];
                this.values[0] = new Value("7", R.raw.good);
                this.values[1] = new Value("10", R.raw.jackpot);
                this.values[2] = new Value("2", R.raw.bad);
                this.values[3] = new Value("1", R.raw.bad);
                break;

            case 4:
                this.gameName = "$1,000,000";

                this.values = new Value[1];
                this.values[0] = new Value("$1,000,000", R.raw.jackpot);
                break;

            case 5:
                this.gameName = "$0.01";

                this.values = new Value[1];
                this.values[0] = new Value("$0.01", R.raw.bad);
                break;

            case 6:
                this.gameName = "D20";

                this.values = new Value[20];
                this.values[0] = new Value("20", R.raw.good);
                this.values[1] = new Value("19", R.raw.good);
                this.values[2] = new Value("18", R.raw.good);
                this.values[3] = new Value("17", R.raw.good);
                this.values[4] = new Value("16", R.raw.good);
                this.values[5] = new Value("15", R.raw.nothing);
                this.values[6] = new Value("14", R.raw.nothing);
                this.values[7] = new Value("13", R.raw.nothing);
                this.values[8] = new Value("12", R.raw.nothing);
                this.values[9] = new Value("11", R.raw.nothing);
                this.values[10] = new Value("10", R.raw.nothing);
                this.values[11] = new Value("9", R.raw.nothing);
                this.values[12] = new Value("8", R.raw.nothing);
                this.values[13] = new Value("7", R.raw.nothing);
                this.values[14] = new Value("6", R.raw.nothing);
                this.values[15] = new Value("5", R.raw.bad);
                this.values[16] = new Value("4", R.raw.bad);
                this.values[17] = new Value("3", R.raw.bad);
                this.values[18] = new Value("2", R.raw.bad);
                this.values[19] = new Value("1", R.raw.bad);
                break;

            case 7:
                this.gameName = "Spooked";

                this.values = new Value[1];
                this.values[0] = new Value("SPOOKED", R.raw.howiescream);

                this.bgmTracks = new Integer[2];
                this.bgmTracks[0] = R.raw.casechoice;
                this.bgmTracks[1] = R.raw.beforeshow;
                break;

            case 8:
                this.gameName = "Gabe";

                this.values = new Value[1];
                this.values[0] = new Value("BARK BORK", R.raw.bork);
                break;

            case 9:
                this.gameName = "Winner";

                this.values = new Value[1];
                this.values[0] = new Value("RAINVILLE", R.raw.jackpot);
                break;
        }
    }

    public Value getRandomValue() {
        int randomIndex = this.generator.nextInt(this.values.length);
        return this.values[randomIndex];
    }

    public Integer getBgm() {
        int randomIndex = this.generator.nextInt(this.bgmTracks.length);
        return this.bgmTracks[randomIndex];
    }

    public String getGameName() {
        return this.gameName;
    }
}
