SquareLayout
=====

SquareLayout is a series of square ViewGroup widgets for Android.

For now, there are three ViewGroups: 

- `SquareRelativeLayout` extends of `RelativeLayout`
- `SquareLinearLayout` extends of `LinearLayout`
- `SquareFrameLayout` extends of `FrameLayout`
 
All of them extend of the original ViewGroups, so
 you can change to a `SquareLayout` you want easily.

# Download

Grab via gradle

```groovy
compile 'com.insightsuen.squarelayout:library:1.0.0'
```

or Maven:
```xml
<dependency>
  <groupId>com.insightsuen.squarelayout</groupId>
  <artifactId>library</artifactId>
  <version>1.0.0</version>
  <type>pom</type>
</dependency>
```

# How do I use SquareLayout?

`SquareLayout` will keep the width and height in same through `MatchType`:

- **MATCH_WIDTH** - The **default** MatchType. The length of SquareLayout will match 
the `LayoutParams.width`, and ignore the original height value.
- **MATCH_HEIGHT** - the length of SquareLayout will match the `LayoutParams.height`, 
and ignore original  width value.
- **MATCH_LENGTH** - the length of SquareLayout will match the `Length` you set. You
can set the value by calling `SquareLayout.setLength(int)` or 
`SquareLayout.setLengthDimenRes(int)`.

You should set the MatchType in layout.xml with one of `width`, `height`, `length` 
e.g. `app:match="width"`. It's recommended to set the ignored 
`andoird:layout_xxxx` attr as `"wrap_content"`.   
Remember set the attr `app:length` when the `app:match` is `"length"`.

## Samples

Here is a layout.xml sample using `SquareRelativeLayout` with MatchType of `MATCH_WIDTH` and
`SquareFrameLayout` whit MatchType of `MATCH_LENGTH`:

``` xml
<com.insightsuen.squarelayout.SquareRelativeLayout
    android:layout_width="200dp"
    android:layout_height="wrap_content"
    android:padding="16dp"
    app:match="width">
            
    <View
        android:layout_width="150dp"
        android:layout_height="120dp"
        android:layout_marginTop="30dp"
        ...
        />
            
    ...

</com.insightsuen.squarelayout.SquareRelativeLayout>

<com.insightsuen.squarelayout.SquareFrameLayout
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    app:length="200dp"
    app:match="length">
            
    <View
            android:layout_width="150dp"
            android:layout_height="120dp"
            android:layout_marginTop="30dp"
            ...
            />
                
        ...
            
</com.insightsuen.squarelayout.SquareFrameLayout>
```


# License

    Copyright (C) 2017 InSight Suen.
    
    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at
    
         http://www.apache.org/licenses/LICENSE-2.0
    
    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.