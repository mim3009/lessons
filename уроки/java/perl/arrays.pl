#!/usr/bin/perl
use strict;
use warnings;
use v5.10;

my @array = ("a", "b", "c");
foreach my $name(@array){
	say $name;
}

say $array[2];

say scalar @array;

for(my $i = 0; $i <= $#array; $i++){
	say $i;
}

push @array, "d";
print @array, "\n";

my $le = pop @array;
say $le;