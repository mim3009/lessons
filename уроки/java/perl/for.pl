use strict;
use warnings;
use v5.10;

my $m = "lalalalalalala";
say "for";
for(my $i = 0; $i < 10; $i++){
	say qq(i == $i);
}
say "-" x length $m;
say "foreach";
foreach my $i(0..9){
	say ($i);
}