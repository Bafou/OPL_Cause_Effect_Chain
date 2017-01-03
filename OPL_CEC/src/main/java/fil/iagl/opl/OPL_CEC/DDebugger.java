package fil.iagl.opl.colombo;

import fil.iagl.opl.colombo.challenge.CauseEffectChain;
import fil.iagl.opl.colombo.challenge.Challenge;

public interface DDebugger<T> {

    CauseEffectChain debug(Challenge<T> c);

}
