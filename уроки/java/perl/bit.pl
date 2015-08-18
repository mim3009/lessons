#!/usr/bin/perl
use strict;
use warnings;
use v5.14;

say "Print value pls";
my $value = <STDIN>;
chomp($value);

my $arr = 0;

for(my $i = 0; $i < $value; $i++){
	my $s = $arr;
	my $n = chop($arr);
	if($n == 1){
		my $h = $s;
		my $t = 0;
		while($h){
			my $f = chop($h);
			if($f == 0){
				$t = 1;
			}
		}
		if($t == 0){
			my $m = length($s);
			$s = "1" . "0"x$m;
		}else{
			my $cnt = 0;
			my $p = $s;
			while(chop($p)!= 0){
				$cnt++;
			}
			$s = $p . "1" . "0"x$cnt;
		}
	}else{
		$s = $s + 1;
	}
	$arr = $s;
}
say $arr;
my $res = 0;
while($arr){
	if(chop($arr) == 1){
		$res++;
	}
}
say $res;