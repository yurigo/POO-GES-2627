void main(){
    // Menu m = new MenuImplementation();
    Menu m = new MenuConsoleWithColors();

    // System.out.println("hola. Pon un numero: ");
    //Scanner sc = new Scanner(System.in);
    // Integer a = sc.nextInt();
    // System.out.println("has puesto " + a);

    m.showMenu();

    m.show("Hola. Pon un numero");
    Integer a = m.getInteger();
    m.show("Has puesto " + a);
}