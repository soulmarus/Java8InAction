package br.com.dnsouza.java8inaction.streams;

import static java.util.stream.Collectors.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import br.com.dnsouza.java8inaction.dto.GridItemsDTO;

public class StreamGroupingSum {
	public static void main(String[] args) {
		
		List<GridItemsDTO> list = generateItems(); 
		
//		Map<Integer, Map<Integer, List<GridItemsDTO>>> groupedList =
//				list.stream().collect(groupingBy(GridItemsDTO::getAcquirerCode, 
//				groupingBy(GridItemsDTO::getParticipantCode)));
//		
//		System.out.println(groupedList.values());
		
//		list.stream().collect(groupingBy(item -> foo::getAcquirerCode, collectingAndThen(reduce(
//				  (a,b)-> new Foo(a.id, a.ref, a.targetCost+b.targetCost, a.actualCost+b.actualCost)),
//				      Optional::get)))
//				  .forEach((id,foo)->System.out.println(foo));	
		
//		list.stream().collect(groupingBy(Function.identity(),
//				  ()-> new TreeMap<> (
//				    // we are effectively grouping by [id, actualCost]
//				    Comparator.<GridItemsDTO,Integer>comparing(linha -> linha.;

		List<Foo> listFoo = new ArrayList<>();
//		list.stream().collect(groupingBy(Function.identity(),
//				  ()->new TreeMap<>(
//				    // we are effectively grouping by [id, actualCost]
//				    Comparator.<GridItemsDTO,Integer>comparing(foo->foo.getAcquirerCode()).thenComparing(foo->foo.getParticipantCode())
//				  ), // and aggregating/ summing targetCost
//				  Collectors.summingInt(foo -> foo.)))
//				.forEach((group,teste) ->
//				    // take the id and actualCost from the group and actualCost from aggregation
//				    System.out.println(group.id+"\t"+group. +"\t"+targetCostSum));		
		
	
		list.stream().collect(groupingBy(Function.identity(),
				  ()->new TreeMap<>(
				    // we are effectively grouping by [id, actualCost]
				    Comparator.<GridItemsDTO,Integer>comparing(foo->foo.getAcquirerCode()).thenComparing(foo->foo.getParticipantCode())
				  ), // and aggregating/ summing targetCost
				  Collectors.summingInt(GridItemsDTO::getLiquidatorBanksCode)))
				.forEach((group,targetCostSum) ->
				    // take the id and actualCost from the group and actualCost from aggregation
				    System.out.println(group.getAcquirerCode()+"\t"+group.getParticipantCode()+"\t"+targetCostSum));
		
//		list.stream().collect(groupingBy(Function.identity(),
//				  ()-> new TreeMap<> (
//				    // we are effectively grouping by [id, actualCost]
//				    Comparator.<GridItemsDTO,Integer>comparing(foo->foo.getAcquirerCode()).thenComparing(foo->foo.getParticipantCode())
//				  ) , // and aggregating/ summing targetCost
//				  Collectors.summingInt(GridItemsDTO::getLiquidatorBanksCode)))
//				.forEach((group,targetCostSum) ->
//				    // take the id and actualCost from the group and actualCost from aggregation
//				    System.out.println(group.getAcquirerCode()+"\t"+group.getLiquidatorBanksCode());		
	}

	private static List<GridItemsDTO> generateItems() {
		
		List<GridItemsDTO> itemsList = new ArrayList<>(); 
		
		IntStream.iterate(1, n -> n + 1).limit(6).forEach((int i) -> {
			itemsList.add(new GridItemsDTO(7253, LocalDate.now().minusDays(Long.valueOf(i)), 46, 1));
		});

		IntStream.iterate(1, n -> n + 1).limit(6).forEach((int i) -> {
			itemsList.add(new GridItemsDTO(90, LocalDate.now().minusDays(Long.valueOf(i)), 46, 1));
		});
		
		IntStream.iterate(1, n -> n + 1).limit(6).forEach((int i) -> {
			itemsList.add(new GridItemsDTO(98, LocalDate.now().minusDays(Long.valueOf(i)), 46, 1));
		});
		
		return itemsList;
	}
	
	
	
}
