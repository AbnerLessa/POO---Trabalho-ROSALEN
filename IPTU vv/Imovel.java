class Imovel {
    private String nomeProprietario;
    private double imposto;
    private int mesesAtraso;

    public Imovel(String nomeProprietario, double imposto, int mesesAtraso) {
        this.nomeProprietario = nomeProprietario;
        this.imposto = imposto;
        this.mesesAtraso = mesesAtraso;
    }

    public double calcularMulta() {
        double multa = 0.0;

        if (mesesAtraso >= 0 && mesesAtraso <= 5) {
            multa = imposto * 0.01;
        } else if (mesesAtraso >= 6 && mesesAtraso <= 8) {
            multa = imposto * 0.023; 
        } else if (mesesAtraso >= 9 && mesesAtraso <= 10) {
            multa = imposto * 0.03; 
        } else if (mesesAtraso >= 11 && mesesAtraso <= 12) {
            multa = imposto * 0.054; 
        } else {
            multa = imposto * 0.1; 
        }

        return multa;
    }
}
