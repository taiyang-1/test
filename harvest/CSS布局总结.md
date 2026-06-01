# CSS 布局总结（Flex + Positioning）

## 一、Flex 弹性布局

### 1.1 核心概念

- **容器**（父元素）：设置 `display: flex;` 的元素
- **项目**（子元素）：容器内的直接子元素
- **主轴**：项目排列的方向，默认水平（左→右）
- **交叉轴**：垂直于主轴的方向

### 1.2 容器属性（写在父元素上）

| 属性 | 作用 | 常用值 |
|------|------|--------|
| `display: flex` | 开启 flex 布局 | `flex`（块级）/ `inline-flex`（行内） |
| `justify-content` | **主轴**对齐 | `flex-start` / `center` / `flex-end` / `space-between` / `space-around` / `space-evenly` |
| `align-items` | **交叉轴**对齐（单行） | `stretch`(默认) / `center` / `flex-start` / `flex-end` |
| `flex-direction` | 主轴方向 | `row`(默认) / `row-reverse` / `column` / `column-reverse` |
| `flex-wrap` | 是否换行 | `nowrap`(默认) / `wrap` |
| `gap` | 项目间距 | 如 `gap: 20px;` |

### 1.3 项目属性（写在子元素上）

| 属性 | 作用 |
|------|------|
| `flex: 1` | `flex-grow` / `flex-shrink` / `flex-basis` 简写，数值表示占几份剩余空间 |
| `align-self` | 单个项目覆盖容器的 `align-items` |

### 1.4 常见模式

```
水平垂直居中：  display: flex; justify-content: center; align-items: center;
两端对齐导航：  display: flex; justify-content: space-between;
等分列布局：    display: flex; gap: 20px; （子元素 flex: 1）
底部固定栏：    display: flex; justify-content: space-between; position: fixed; bottom: 0;
```

---

## 二、Position 定位

### 2.1 偏移属性 top / right / bottom / left

开启定位后（非 static），用这四个属性控制元素往哪偏移：

- `top: 10px` → 离参考目标**顶部** 10px（向下移）
- `left: 20px` → 离参考目标**左边** 20px（向右移）
- 也可以用负值反向偏移，如 `top: -8px`（向上超出）

### 2.2 五种定位详解

#### static（默认）
```
不写 position 就是这个值。元素按 HTML 顺序正常排列。
top/left/z-index 对它无效。
```

#### relative（相对定位）
```css
position: relative;
top: 10px;    /* 从自己原来的位置向下移 10px */
left: 30px;   /* 从自己原来的位置向右移 30px */
```
- **不脱离文档流**：原来的坑位还留着，后面的元素不会顶上来
- 偏移参考：**自己原来的位置**
- 主要用途：
  1. 微调元素位置
  2. 作为 `absolute` 子元素的**定位锚点**（父 relative + 子 absolute）

#### absolute（绝对定位）
```css
position: absolute;
top: 10px;
right: 10px;
```
- **脱离文档流**：原来的坑位消失，后面元素会顶上来
- 偏移参考：向上找最近的**有定位的祖先**（position 不是 static）
- 如果所有祖先都是 static，就相对于 `<body>` 定位
- 典型用途：角标徽章、下拉菜单、弹框

#### fixed（固定定位）
```css
position: fixed;
bottom: 0;
left: 0;
width: 100%;
```
- **脱离文档流**
- 偏移参考：**浏览器视口**（可视区域），滚动页面时位置不动
- 典型用途：固定导航栏、回到顶部按钮、右下角客服弹窗

#### sticky（粘性定位）
```css
position: sticky;
top: 0;
```
- **relative + fixed 的混合体**：平时像 relative 正常滚动，到达阈值（如 `top: 0`）后像 fixed 粘住不动
- 偏移参考：最近的**有滚动的祖先**
- 典型用途：表格标题行、分类标题栏、侧边栏目录

### 2.3 五种定位对比表

| 值 | 脱离文档流 | 定位参考 | 典型用途 |
|----|-----------|----------|----------|
| `static` | ❌ | 无（默认文档流） | 默认值 |
| `relative` | ❌（保留坑位） | 自己原来的位置 | 微调、做 absolute 锚点 |
| `absolute` | ✅（坑位消失） | 最近的有定位祖先 | 角标、下拉菜单、弹框 |
| `fixed` | ✅ | 浏览器视口 | 固定导航、客服按钮 |
| `sticky` | ❌（平时）/ ✅（粘住时） | 视口 | 分类标题、侧边栏 |

### 2.4 关键搭配

**子绝父相**（最常用定位组合）：
```css
.parent {
  position: relative;  /* 只设 relative，不设偏移 → 作为"锚点" */
}
.child {
  position: absolute;
  top: -8px;           /* 超出父容器一点 */
  right: -8px;
}
```
父元素只做锚点、不偏移；子元素用 absolute 相对父容器自由定位。

**z-index（层叠顺序）**：
- 只对**非 static** 定位的元素生效
- 值越大越靠上（离用户越近），默认 auto ≈ 0
- 数字可以随便写（1, 2, 10, 100, 999），无单位

### 2.5 文档流

元素默认按 HTML 顺序从上到下排列 → **文档流**

| 状态 | 哪些定位 |
|------|---------|
| 不脱离（保留坑位） | `static`、`relative`、`sticky`（平时） |
| 脱离（坑位消失） | `absolute`、`fixed`

---

## 三、Flex vs Position 选择指南

| 场景 | 用什么 |
|------|--------|
| 一维排列（横/纵） | Flex |
| 元素间对齐、均分 | Flex (`justify-content`, `flex: 1`) |
| 元素脱离正常流、盖在其他元素上 | Position (`absolute`, `fixed`) |
| 固定在屏幕某个位置（不随滚动） | `position: fixed` |
| 父容器内自由定位子元素 | 父 `relative` + 子 `absolute` |
| 滚动到特定位置后吸顶 | `position: sticky` |

> Flex 解决"内部排列"，Position 解决"页面定位"。两者常组合使用。
