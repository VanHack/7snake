package org.vanhack.sevensnake.model;

import java.io.File;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class GraphTest {

	private static final int[][] TEST_CSV_FILE_MATRIX =
		{ 
			{1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
			{2, 3, 4, 5, 6, 7, 8, 9, 10, 11},
			{3, 4, 5, 6, 7, 8, 9, 10, 11, 12},
			{4, 5, 6, 7, 8, 9, 10, 11, 12, 13},
			{5, 6, 7, 8, 9, 10, 11, 12, 13, 14},
			{6, 7, 8, 9, 10, 11, 12, 13, 14, 15},
			{7, 8, 9, 10, 11, 12, 13, 14, 15, 16},
			{8, 9, 10, 11, 12, 13, 14, 15, 16, 17},
			{9, 10, 11, 12, 13, 14, 15, 16, 17, 18},
			{10, 11, 12, 13, 14, 15, 16, 17, 18, 19},
		
		};
	
	@Test
	public void should_load_csv(){
		Graph graph = new Graph(new File(getClass().getResource("/test.csv").getFile()));
		Assertions.assertThat(graph.matrix).isEqualTo(TEST_CSV_FILE_MATRIX);
	}
}
