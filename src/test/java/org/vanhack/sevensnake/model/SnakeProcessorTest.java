package org.vanhack.sevensnake.model;

import java.io.File;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.vanhack.sevensnake.seeker.SnakeMatchSeeker;

public class SnakeProcessorTest {

	@Test
	public void shouldFindAMatch(){
		Graph graph = new Graph(new File(getClass().getResource("/match.csv").getFile()));
		SnakeMatchSeeker processor = new SnakeMatchSeeker(graph);
		SnakeMatch m = processor.findMatch();
		Assertions.assertThat(m).isNotNull();
		System.out.println(m);
	}
	

	@Test
	public void shouldFindAMatchInChallenge(){
		Graph graph = new Graph(new File(getClass().getResource("/challengeSample.csv").getFile()));
		SnakeMatchSeeker processor = new SnakeMatchSeeker(graph);
		SnakeMatch m = processor.findMatch();
		Assertions.assertThat(m).isNotNull();
		System.out.println(m);
	}
	
}
