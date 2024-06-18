# Code Generation

This module defines the local `pods4k-code-generator` gradle plugin for the auto-generated portions of this library.
This increases the safety of the library and reduces defects by using a single code path to generate capabilities that
are mostly duplicates aside from their types such as when creating specializations for each of the 8 base types. Note
that some capabilities are multiplicative so if each of the 8 primitive immutable array types needs a capability
that's specialized for each of the 8 base types again (like the `map` function) then we have 64 variations of this
capability.

Auto-generating this type of code significantly reduces the maintenance overhead and risk as we only need to modify 1
place and have all the specializations auto-generated instead of needing to manually maintain multiple variations.
