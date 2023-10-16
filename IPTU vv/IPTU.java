public class IPTU {
    public static void main(String[] args) {
        Imovel imovel1 = new Imovel("Proprietario1", 1000, 3);
        Imovel imovel2 = new Imovel("Proprietario2", 2000, 8);

        Municipio municipio = new Municipio();
        municipio.adicionarImovel(imovel1);
        municipio.adicionarImovel(imovel2);

        municipio.calcularMultaImoveis();
    }
}
