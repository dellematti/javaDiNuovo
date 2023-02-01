interface Listino{
    // REQUIRES : ---
    // MODIFIES : ---
    // EFFECTS : restituisce il prezzo dell acquisto di una determinata quantità di un tipo di giocattolo
    //           se quantità <= 0 viene lanciata un eccezione di tipo IllegalArgumentException
    public int prezzo(final int quantità, final Giocattolo giocattolo);
}