package br.com.dnsouza.java8inaction.streams;

import static java.util.stream.Collectors.groupingBy;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.IntStream;

import br.com.dnsouza.java8inaction.dto.GridItemsDTO;

public class StreamGroupingSum {

    private static List<GridItemsDTO> generateItems() {

        List<GridItemsDTO> itemsList = new ArrayList<>();

        IntStream.iterate(1, n -> n + 1).limit(6).forEach((final int i) -> {
            itemsList.add(new GridItemsDTO(7253, LocalDate.now().minusDays(Long.valueOf(i)), 46,
                            new Random().nextInt(2),
                            BigDecimal.valueOf(new Random().nextInt(1500))));
        });

        IntStream.iterate(1, n -> n + 1).limit(6).forEach((final int i) -> {
            itemsList.add(new GridItemsDTO(90, LocalDate.now().minusDays(Long.valueOf(i)), 46,
                            new Random().nextInt(2),
                            BigDecimal.valueOf(new Random().nextInt(1500))));
        });

        IntStream.iterate(1, n -> n + 1).limit(6).forEach((final int i) -> {
            itemsList.add(new GridItemsDTO(98, LocalDate.now().minusDays(Long.valueOf(i)), 46,
                            new Random().nextInt(2),
                            BigDecimal.valueOf(new Random().nextInt(1500))));
        });

        return itemsList;
    }

    public static void main(final String[] args) {

        List<GridItemsDTO> list = generateItems();
        System.out.println("linhas completas");
        System.out.println(list.size());
        list.stream().forEach(System.out::println);
        new ArrayList<>();
        List<GridItemsDTO> listaSumarizada = new ArrayList<>();

        Map<String, List<GridItemsDTO>> listaAgrupada = list.stream()
                        .collect(groupingBy(GridItemsDTO::toItemKey));

        System.out.println("linhas listaAgrupada");
        System.out.println(listaAgrupada.size());
        listaAgrupada.values().stream().forEach(System.out::println);

        listaAgrupada.values().stream()
                        .map(GridItemsDTO::sumarizarLinhas)
                        // .sorted()
                        .forEach(listaSumarizada::add);

        System.out.println("linhas sumarizadas");
        System.out.println(listaSumarizada.size());
        listaSumarizada.stream().forEach(System.out::println);

    }

}
