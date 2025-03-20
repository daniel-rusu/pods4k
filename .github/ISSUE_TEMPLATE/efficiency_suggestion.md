---
name: Performance or efficiency idea
about: Suggest a performance or efficiency improvement
title: ''
labels: performance / efficiency
assignees: ''

---

### Performance or efficiency improvement

A high-level description of the performance or efficiency improvement that you're suggesting.

```
Eg. The `partition` operation should use a perfectly-sized double-sided buffer instead of appending
results to 2 separate dynamically-growing builders. Elements that pass the predicate should be added
to the front of the buffer and the others to the end so that both sides grow inwards towards the
center.  After populating the buffer, copy the elements into 2 perfectly-sized results.
```

### Memory and Performance impacts

A brief comment of how this might affect memory consumption or performance.

```
Eg. This reduces memory overhead as the double-sided buffer would be perfectly sized whereas appending
to 2 builders ends up with extra unused capacity in each builder.  This also avoids the temporary memory
of previously-discarded buffers as resizing no longer occurs which should also improve performance.
```

### Potential alternatives

A very brief list of alternative improvements that you considered for this in case we can combine multiple ideas.

### Additional context

If the benefits of this proposal aren't obvious, include a use-case that would benefit from this enhancement. Ideally,
this should be a common scenario as that would make this enhancement more valuable.
