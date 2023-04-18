<template>
   <div>
    <input type="file" ref="fileInput" @change="uploadImage" />
  </div>
</template>

<script>
import { createUploadWidget } from "cloudinary-widget";

export default {
  methods: {
    uploadImage() {
      const widget = createUploadWidget(
        {
          cloudName: "dlh24zlzm",
          uploadPreset: "cloudinary_unsigned",
        },
        (error, result) => {
          if (!error && result && result.event === "success") {
            const imageUrl = result.info.secure_url;
            this.$emit("image-uploaded", { url: imageUrl });
          }
        }
      );
      widget.open();
    },
  },
};

</script>

<style>

</style>