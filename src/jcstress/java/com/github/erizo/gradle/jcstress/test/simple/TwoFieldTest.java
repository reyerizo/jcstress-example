package com.github.erizo.gradle.jcstress.test.simple;

import org.openjdk.jcstress.annotations.Actor;
import org.openjdk.jcstress.annotations.Description;
import org.openjdk.jcstress.annotations.JCStressTest;
import org.openjdk.jcstress.annotations.Outcome;
import org.openjdk.jcstress.annotations.State;
import org.openjdk.jcstress.infra.results.LL_Result;

import static org.openjdk.jcstress.annotations.Expect.ACCEPTABLE;
import static org.openjdk.jcstress.annotations.Expect.ACCEPTABLE_INTERESTING;

@JCStressTest
@Description("Tests safeIncrementValue is threadsafe")
@Outcome.Outcomes({
        @Outcome(id = "0, 0", expect = ACCEPTABLE, desc = "Object not constructed yet"),
        @Outcome(id = "1, 0", expect = ACCEPTABLE, desc = "Object half-way"),
        @Outcome(id = "1, 2", expect = ACCEPTABLE, desc = "Object fully constructed"),
        @Outcome(expect = ACCEPTABLE_INTERESTING, desc = "Reordered"),
})
@State()
public class TwoFieldTest {

    private TwoFields twoFields = new TwoFields(0, 0);

    @Actor
    public void actor1() {
        twoFields.setX(1);
        twoFields.setY(2);
    }

    @Actor
    public void actor2(LL_Result longResult) {
        longResult.r1 = twoFields.x;
        longResult.r2 = twoFields.y;
    }

}
