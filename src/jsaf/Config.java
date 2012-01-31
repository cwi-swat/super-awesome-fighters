package jsaf;

import java.util.Arrays;
import java.util.List;

public interface Config {
	final List<String> ATOMS =
			Arrays.asList("near", "even", "far", "always", "stronger", "weaker", "much_stronger", "much_weaker");

	final List<String> MOVES =
			Arrays.asList("jump", "crouch", "stand", "run_towards", "run_away", "walk_towards", "walk_away");

	final List<String> FIGHTS =
			Arrays.asList("punch_low", "punch_high", "kick_low", "kick_high", "block_low", "block_high");

	final List<String> STRENGTHS =
			Arrays.asList("punchReach", "kickReach", "kickPower", "punchPower");

	final Integer MIN_STRENGTH = 1;
	final Integer MAX_STRENGTH = 10;

}
