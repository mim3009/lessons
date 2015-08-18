#!/usr/bin/perl
use strict;
use warnings;
use v5.10;

my $filename = "input.txt";
open(my $fh, "<", $filename) or die "Can`t open file '$filename' . $!";
	while(my $line = <$fh>){
		print $line;
	}
close $fh;

