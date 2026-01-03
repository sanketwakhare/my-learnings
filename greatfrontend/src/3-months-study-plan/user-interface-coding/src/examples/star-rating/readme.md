## Star Rating Widget

Create a star rating widget that allows users to select a rating value.

---

### Requirements

- The widget accepts two parameters:
  - The maximum number of stars
  - The number of currently filled stars
- When a star is clicked, it is filled along with all the stars to its left.
- Hovering over a star fills that star and all stars to its left.
- The stars which need to be filled during hover take priority over the existing filled state.
- If the cursor leaves the widget and no new selection is made, the appropriate stars revert to the filled state before hovering.
- Make the star rating widget reusable such that multiple instances can be rendered within the same page.
- The star icons, both empty and filled, are provided to you as SVGs.

---

A `StarRating.js` skeleton component has been created for you. You are free to decide the props of `<StarRating />`.
