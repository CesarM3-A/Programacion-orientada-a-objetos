package proyectobibliopoo;

public class ValidacionCedula {
    public static boolean validarCedula(String cedula) {
        if (cedula == null || cedula.length() != 10) return false;
        
        try {
            int provincia = Integer.parseInt(cedula.substring(0, 2));
            if (provincia < 1 || provincia > 24) return false;

            int tercerDigito = Character.getNumericValue(cedula.charAt(2));
            if (tercerDigito >= 6) return false;

            int[] coeficientes = {2, 1, 2, 1, 2, 1, 2, 1, 2};
            int suma = 0;

            for (int i = 0; i < 9; i++) {
                int valor = Character.getNumericValue(cedula.charAt(i)) * coeficientes[i];
                suma += (valor > 9) ? (valor - 9) : valor;
            }

            int digitoVerificador = Character.getNumericValue(cedula.charAt(9));
            int decenaSuperior = (suma + 9) / 10 * 10;
            int resultado = decenaSuperior - suma;
            if (resultado == 10) resultado = 0;

            return resultado == digitoVerificador;
        } catch (Exception e) { return false; }
    }
}