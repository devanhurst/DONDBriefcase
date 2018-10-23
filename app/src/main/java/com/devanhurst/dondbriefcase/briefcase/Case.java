package com.devanhurst.dondbriefcase.briefcase;

import java.util.Random;
import com.devanhurst.dondbriefcase.R;

public class Case {
    private Value[] values;
    private Random generator = new Random();

    public Case(Integer gameId) {
        switch (gameId) {
            case 1:
                this.values = new Value[7];
                this.values[0] = new Value("$1,000,000", R.raw.bad);
                this.values[1] = new Value("$500,000", R.raw.bad);
                this.values[2] = new Value("$100,000", R.raw.bad);
                this.values[3] = new Value("$10,000", R.raw.good);
                this.values[4] = new Value("$1,000", R.raw.good);
                this.values[5] = new Value("$100", R.raw.good);
                this.values[6] = new Value("$0.01", R.raw.good);
                break;
        }
    }

    public Value getRandomValue() {
        int randomIndex = this.generator.nextInt(this.values.length);
        return this.values[randomIndex];
    }
}
