# CSS 布局易错点汇总

## 1. flex: 1 的含义
`flex: 1` 是 flex 子项属性的简写，不等于 `display: flex`！

```css
flex: 1;
/* 等价于：*/
flex-grow: 1;      /* 有剩余空间时，按比例瓜分 */
flex-shrink: 1;    /* 空间不足时，按比例收缩 */
flex-basis: 0%;     /* 初始大小为 0，只分剩余空间 */
```

- `display: flex` → 写在容器上，让它变成弹性容器
- `flex: 1` → 写在子项上，让子项等分剩余空间

## 2. justify-content 各值区别
```
space-between:  |■  空格  ■  空格  ■|    两端贴边
space-around:   |半格 ■ 全格 ■ 全格 ■ 半格|   每个元素两侧相等
space-evenly:   |等格 ■ 等格 ■ 等格 ■ 等格|   所有间隙完全相等
```

## 3. fixed vs sticky
| | position: fixed | position: sticky |
|---|---|---|
| 参照物 | 浏览器视口（viewport） | 最近的滚动容器 |
| 行为 | 永远固定在屏幕位置 | 先正常滚动，到达阈值后粘住 |
| 例子 | 右下角"回到顶部"按钮 | 表格表头滚到顶部后固定 |

口诀：fixed = 定死在屏幕上；sticky = 先跟滚再粘住

## 4. 子绝父相原理
- 父元素 `position: relative`（不动，只声明参照权）
- 子元素 `position: absolute`（相对于父元素定位）
- 绝对定位参照物是「最近的有定位的祖先」，如果不给父 relative，会一直找到 body

## 5. align-items vs align-content
| | align-items | align-content |
|---|---|---|
| 作用于 | 每一行内的子项 | 行与行之间 |
| 何时生效 | 单行就生效 | 必须多行 + flex-wrap: wrap |

- align-items：控制交叉轴上单行子项的对齐（stretch/flex-start/center/flex-end）
- align-content：多行版 justify-content，控制行间距分布
