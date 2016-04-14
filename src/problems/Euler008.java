package problems;

import static org.junit.Assert.assertEquals;

import java.util.stream.Stream;

import org.junit.Test;

public class Euler008 {

	@Test
	public void test() {
		String s = "7316717653133062491922511967442657474235"
					+"5349194934969835203127745063262395783180"
					+"1698480186947885184385861560789112949495"
					+"4595017379583319528532088055111254069874"
					+"7158523863050715693290963295227443043557"
					+"6689664895044524452316173185640309871112"
					+"1722383113622298934233803081353362766142"
					+"8280644448664523874930358907296290491560"
					+"4407723907138105158593079608667017242712"
					+"1883998797908792274921901699720888093776"
					+"6572733300105336788122023542180975125454"
					+"0594752243525849077116705560136048395864"
					+"4670632441572215539753697817977846174064"
					+"9551492908625693219784686224828397224137"
					+"5657056057490261407972968652414535100474"
					+"8216637048440319989000889524345065854122"
					+"7588666881164271714799244429282308634656"
					+"74813919123162824586178664583591245665294"
					+"76545682848912883142607690042242190226710"
					+"55626321111109370544217506941658960408071"
					+"98403850962455444362981230987879927244284"
					+"90918884580156166097919133875499200524063"
					+"68991256071760605886116467109405077541002"
					+"25698315520005593572972571636269561882670"
					+"428252483600823257530420752963450";
		
		
		long max = Stream.iterate(0, n -> n + 1).limit(s.length()-13)
			.map(i -> {
				String window = s.substring(i, i+13);
				if(window.contains("0")) return 0l;
				long prod = window.chars()
							.map(c -> Character.getNumericValue(c))
							.mapToLong(n -> (long)n)
							.reduce(1, (a, b) -> a * b);
				return prod;
			})
			.reduce(0l, (m, n) -> m >= n ? m : n);
		
		System.out.println(max);
		
		assertEquals(23514624000l, max);
	}
}
