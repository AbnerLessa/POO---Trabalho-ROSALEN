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
            multa = imposto * 0.01; // 1% de multa
        } else if (mesesAtraso >= 6 && mesesAtraso <= 8) {
            multa = imposto * 0.023; // 2.3% de multa
        } else if (mesesAtraso >= 9 && mesesAtraso <= 10) {
            multa = imposto * 0.03; // 3% de multa
        } else if (mesesAtraso >= 11 && mesesAtraso <= 12) {
            multa = imposto * 0.054; // 5.4% de multa
        } else {
            multa = imposto * 0.1; // 10% de multa para atraso superior a 12 meses
        }

        return multa;
    }
}
