import java.util.Arrays;

public class ValidaCpf {

	public static void main(String[] args) {
		String cpf = "41746933828";

		StringBuilder stringBuilder = new StringBuilder(cpf);
		for (int c = 1; c < 11; c++) {
			stringBuilder.insert(cpf.length() - c, ',');
		}
		System.out.println(stringBuilder.toString());

		String k = stringBuilder.toString();
		String array[] = new String[stringBuilder.length()];

		array = k.split(",");

		int[] arrayn = Arrays.stream(array).mapToInt(Integer::parseInt).toArray();

		for (int s = 0; s < 2; s++) {

			boolean PrimeiroDigito = (s == 0) ? true : false;
			int contador = 0;
			int total = 0;
			for (int kk : arrayn) {
				for (int i = (PrimeiroDigito == false) ? 11 : 10; i >= 2; i++) {
					i -= contador;
					total += kk * i;
					contador++;
					break;
				}
				if (PrimeiroDigito == true && contador == 9 || PrimeiroDigito == false && contador == 10) {
					break;
				}
			}
			System.out.println(total);

			int verificador = total * 10 % 11;
			System.out.println(verificador);

			if (verificador == arrayn[arrayn.length - 2]) {
				System.out.println("true");
				System.out.println("O primeiro digito verificador é: " + arrayn[arrayn.length - 2]);
			}
			if (verificador == arrayn[arrayn.length - 1]) {
				System.out.println("true");
				System.out.println("O segundo digito verificador é: " + arrayn[arrayn.length - 1]);
			}
		}
	}

}
