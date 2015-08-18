#!/usr/bin/perl
use strict;
use warnings;

#my $filename = "input.txt";
#if(my $fh, "<", $filename){
#	
#}else{
#	warn "Coul`d not open file '$filename' . $!";	
#}

my $filename = "input.txt";
open(my $fh, "<", $filename) or die "Coul`d not open file '$filename' . $!";

close $fh;