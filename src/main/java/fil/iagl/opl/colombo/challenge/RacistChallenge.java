package fil.iagl.opl.colombo.challenge;

import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class RacistChallenge implements Challenge<Color> {

	@Override
	public Class<Color> getInputFormat() {
		return Color.class;
	}

	@Override
	public List<Color> getInputs() {
		return Arrays.asList(Color.WHITE, Color.BLUE, Color.CYAN, Color.RED);
	}

	@Override
	public Object doIt(Color input) {
		return null;
	}

	@Override

	public void challenge(Color input) {
		for (int i = 0 ; i < 10 ; i++) {
			System.out.println("toto");
		}
		if (input != null) {
			int blueLevel = input.getBlue();//NOSONAR
			assert blueLevel != 0;
		}
	}

}
