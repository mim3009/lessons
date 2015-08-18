use strict;
use warnings;

my $str = <<'END_STRING';
some text
sOMe tEXt
END_STRING

print "$str";

print "\n---\n";

my $other = <<'END_OTHER';
Begin
$str
End
END_OTHER

print "$other\n";