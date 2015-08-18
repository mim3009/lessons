use strict;
use warnings;
use v5.14;

my @arr = (3,6,1,2,8,9,5,7);
for(my $i = 0 ; $i < scalar(@arr); $i++){
	for(my $j = 0; $j < scalar(@arr)-$i-1; $j++){
		if($arr[$j] > $arr[$j+1]){
			($arr[$j],$arr[$j+1])=($arr[$j+1],$arr[$j]);
		}
	}
}
say @arr;