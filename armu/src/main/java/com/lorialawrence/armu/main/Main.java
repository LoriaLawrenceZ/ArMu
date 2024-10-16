package com.lorialawrence.armu.main;

import com.lorialawrence.armu.model.Artista;
import com.lorialawrence.armu.model.Genero;
import com.lorialawrence.armu.model.Musica;
import com.lorialawrence.armu.repository.ArtistaRepository;
import com.lorialawrence.armu.repository.MusicaRepository;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {

    private final Scanner sc = new Scanner(System.in);
    private final ArtistaRepository artistaRepository;
    private final MusicaRepository musicaRepository;

    public Main(ArtistaRepository artistaRepository, MusicaRepository musicaRepository) {
        this.artistaRepository = artistaRepository;
        this.musicaRepository = musicaRepository;
    }

    public void menu() {

        String escolhaMenu;

        while (true) {
            do {
                System.out.println("""
                        \n
                        --------------------
                        
                        1 - Cadastrar artista
                        2 - Cadastrar música
                        3 - Listar artistas
                        4 - Listar músicas
                        5 - Pesquisar artista por nome
                        6 - Pesquisar música por nome
                        
                        0 - Sair
                        """);

                escolhaMenu = sc.nextLine();

            } while (
                    !escolhaMenu.equals("1") &&
                    !escolhaMenu.equals("2") &&
                    !escolhaMenu.equals("3") &&
                    !escolhaMenu.equals("4") &&
                    !escolhaMenu.equals("5") &&
                    !escolhaMenu.equals("6") &&
                    !escolhaMenu.equals("0")
            );

            switch (escolhaMenu) {
                case "1":
                    cadastrarArtista();
                    break;
                case "2":
                    cadastrarMusica();
                    break;
                case "3":
                    listarArtistas();
                    break;
                case "4":
                    listarMusicas();
                    break;
                case "5":
                    pesquisarArtistaPorNome();
                    break;
                case "6":
                    pesquisarMusicaPorNome();
                    break;
                case "0":
                    System.out.println("Saindo...");
                    System.exit(0);
                    break;
            }
        }
    }

    private void cadastrarArtista() {
        System.out.println("Digite o nome do artista: ");
        String nome = sc.nextLine();
        System.out.println("Digite a idade do artista: ");
        int idade = Integer.parseInt(sc.nextLine());
        System.out.println("Digite a terra natal do artista: ");
        String terraNatal = sc.nextLine();

        Artista artista = new Artista(nome, idade, terraNatal);
        artistaRepository.save(artista);
    }

    private void cadastrarMusica() {
        System.out.println("Digite o nome do artista: ");
        String nomeArtista = sc.nextLine();

        Optional<Artista> artista = artistaRepository.findByNomeContainingIgnoreCase(nomeArtista);

        artista.ifPresentOrElse(
            a -> {
                System.out.println("Digite o nome da música: ");
                String nome = sc.nextLine();

                Arrays.stream(Genero.values()).forEach(g -> System.out.print(g + "; "));
                System.out.println("\nDigite o gênero da música: ");
                String genero = sc.nextLine();
                Genero tipoGenero = Genero.valueOf(genero.toUpperCase());

                System.out.println("Digite a duração da música: ");
                String duracao = sc.nextLine();

                System.out.println("Digite a letra da música: ");
                String letra = sc.nextLine();

                System.out.println("Digite a data de lançamento da música: ");
                LocalDate dataLancamento = LocalDate.parse(sc.nextLine(), java.time.format.DateTimeFormatter.ofPattern("dd-MM-yyyy"));

                Musica musica = new Musica(nome, tipoGenero, duracao, letra, dataLancamento, a);
                musicaRepository.save(musica);
                a.getMusicas().add(musica);
            },
            () -> System.out.println("Artista não encontrado.")
        );
    }

    private void listarArtistas() {
        List<Artista> artistas = artistaRepository.findAll();
        artistas.forEach(System.out::println);
    }

    private void listarMusicas() {
        List<Musica> musicas = musicaRepository.findAll();
        musicas.forEach(System.out::println);
    }

    private void pesquisarArtistaPorNome() {

    }

    private void pesquisarMusicaPorNome() {

    }
}
