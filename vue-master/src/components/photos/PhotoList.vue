<template>
    <div>
        <div id="slider" class="mui-slider">
				<div id="sliderSegmentedControl" class="mui-scroll-wrapper mui-slider-indicator mui-segmented-control mui-segmented-control-inverted">
					<div class="mui-scroll">
						<a class="mui-control-item mui-active" href="#item1mobile" data-wid="tab-top-subpage-1.html">
							推荐
						</a>
						<a class="mui-control-item" href="#item2mobile" data-wid="tab-top-subpage-2.html">
							热点
						</a>
						<a class="mui-control-item" href="#item3mobile" data-wid="tab-top-subpage-3.html">
							北京
						</a>
						<a class="mui-control-item" href="#item4mobile" data-wid="tab-top-subpage-4.html">
							社会
						</a>
						<a class="mui-control-item" href="#item5mobile" data-wid="tab-top-subpage-5.html">
							娱乐
						</a>
					</div>
				</div>

				<ul class="photo-list">
					<li v-for="item in photoList" :key="item.id">
					<img v-lazy="item.img">
					</li>
				</ul>
			</div>
    </div>
</template>

<script>
	export default {
	data() {
		return {
		photoList: []
		};
	},
	created() {
		this.getPhotoList();
	},
	methods: {
		//获取图片详情
		getPhotoList() {
		this.$http.get("./data/photoList.json").then(result => {
			this.photoList = result.body;
		});
		}
	}
	};
</script>


<style lang="less" scoped>
	.photo-list {
		margin: 0;
		padding: 0;
	li {
		img{
			width: 100%;
		}
		list-style: none;
		
		img[lazy="loading"] {
			width: 40px;
			height: 300px;
			margin: auto;
		}
	}
	}
</style>
