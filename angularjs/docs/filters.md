# filters
* change how we present data to the user
* built in filters
  * currency
  * date
  * lowercase
  * uppercase
  * filter
* Yes, there is a filter filter

```javascript
{{ "hello WORLD" | lowercase }}

{{ 100.236 | currency }}

{{ 1288323623006 | date }}

{{ 1288323623006 | date:"medium" }}
```


```html
<input type="text" data-ng-model="squirrel"/>

<ul>
  <li data-ng-repeat="person in cat.people | orderBy:'state' | filter:squirrel">
    {{person.name}}, {{person.state}}
  </li>
</ul>
```
