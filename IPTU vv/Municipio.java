class Municipio {
    private List<Imovel> imoveis;

    public Municipio() {
        imoveis = new ArrayList<>();
    }

    public void adicionarImovel(Imovel imovel) {
        imoveis.add(imovel);
    }

    public void calcularMultaImoveis() {
        for (Imovel imovel : imoveis) {
            double multa = imovel.calcularMulta();
            System.out.println("Proprietário: " + imovel.nomeProprietario);
            System.out.println("Valor do imposto: " + imovel.imposto);
            System.out.println("Meses de atraso: " + imovel.mesesAtraso);
            System.out.println("Multa a ser paga: " + multa);
            System.out.println();
        }
    }
}
